/*
 Copyright (C) 2015  Nikos Siatras

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 SourceRabbit GCode Sender is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package sourcerabbit.gcode.sender.Core.CNCController.GCode;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sourcerabbit.gcode.sender.Core.CNCController.Position.Position4D;

/**
 *
 * @author Nikos Siatras
 */
public class GCodeCommand {

    private String fCommand;
    private String fComment = "", fError = "";

    // Command GCodes and coordinates
    private ArrayList<String> fGCodes;
    private Position4D fCoordinates;

    public GCodeCommand(String command) {
        if (command.startsWith("(")) {
            fCommand = "";
            return;
        } else {
            fCommand = command;
        }

        // Find command comments
        if (fCommand.contains(";")) {
            int commentPosition = fCommand.indexOf(";");
            fComment = fCommand.substring(commentPosition + 1);
            fCommand = fCommand.substring(0, commentPosition);
        }
    }

    /**
     * Returns a clear and optimized command without comments and white spaces
     *
     * @return a clear and optimized command without comments and white spaces
     */
    public String getOptimizedCommand() {
        String optimized = GCodeOptimizer.OptimizeGCodeCommand(this);
        return GCodeOptimizer.OptimizeGCodeCommand(this);

    }

    /**
     * Returns the command coordinates A,X,Y,Z
     *
     * @return the command coordinates A,X,Y,Z
     */
    public Position4D getCoordinates() {
        if (fCoordinates == null) {
            final Pattern pattern = Pattern.compile("[AXYZ][+-]?[0-9]*\\.?[0-9]*\\.?[0-9]­*");
            final Matcher m = pattern.matcher(fCommand);
            Float x = null, y = null, z = null, a = null;
            while (m.find()) {
                final String groupStr = m.group();
                if (groupStr.contains("X")) {
                    x = Float.parseFloat(groupStr.replace("X", ""));
                } else if (groupStr.contains("Y")) {
                    y = Float.parseFloat(groupStr.replace("Y", ""));
                } else if (groupStr.contains("Z")) {
                    z = Float.parseFloat(groupStr.replace("Z", ""));
                } else if (groupStr.contains("A")) {
                    a = Float.parseFloat(groupStr.replace("A", ""));
                }
            }

            fCoordinates = new Position4D(x, y, z, a);
        }

        return fCoordinates;
    }

    /**
     * Returns the command GCodes
     *
     * @return the command GCodes
     */
    public ArrayList<String> getCommandGCodes() {
        if (fGCodes == null) {
            Pattern pattern = Pattern.compile("[GMN][+-]?[0-9]*\\.?[0-9]*\\.?[0-9]­*");
            Matcher m = pattern.matcher(fCommand);
            while (m.find()) {
                String groupStr = m.group();
                fGCodes.add(groupStr);
            }
        }

        return fGCodes;
    }

    /**
     * Returns the command
     *
     * @return the command
     */
    public String getCommand() {
        return fCommand;
    }

    /**
     * Returns the command's comment
     *
     * @return the command comment
     */
    public String getComment() {
        return fComment;
    }

    /**
     * Set command's error
     *
     * @param error
     */
    public void setError(String error) {
        fError = error;
    }

    /**
     * Returns command's error
     *
     * @return command's error
     */
    public String getError() {
        return fError.trim();
    }
}
