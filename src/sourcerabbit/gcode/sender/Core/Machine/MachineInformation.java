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
package sourcerabbit.gcode.sender.Core.Machine;

/**
 *
 * @author Nikos Siatras
 */
public class MachineInformation {

    public static final MachineInformation_LiveFeedRate feedRate = new MachineInformation_LiveFeedRate();
    public static final MachineInformation_LiveSpindleRPM spindleRPM = new MachineInformation_LiveSpindleRPM();

}
