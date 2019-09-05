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
package sourcerabbit.gcode.sender.Core.CNCController.Connection.Events.GCodeExecutionEvents;

import sourcerabbit.gcode.sender.Core.CNCController.Connection.Events.EventManager;

/**
 *
 * @author Nikos Siatras
 */
public class GCodeExecutionEventsManager extends EventManager
{

    public GCodeExecutionEventsManager()
    {

    }

    public void FireGCodeCommandSentToController(GCodeExecutionEvent evt)
    {
        for (Object obj : fEventListeners)
        {
            IGCodeExecutionEventListener listener = (IGCodeExecutionEventListener) obj;
            listener.GCodeCommandSentToController(evt);
        }
    }

    public void FireGCodeExecutedSuccessfully(GCodeExecutionEvent evt)
    {
        for (Object obj : fEventListeners)
        {
            IGCodeExecutionEventListener listener = (IGCodeExecutionEventListener) obj;
            listener.GCodeExecutedSuccessfully(evt);
        }
    }

    public void FireGCodeExecutedWithError(GCodeExecutionEvent evt)
    {
        for (Object obj : fEventListeners)
        {
            IGCodeExecutionEventListener listener = (IGCodeExecutionEventListener) obj;
            listener.GCodeExecutedWithError(evt);
        }
    }

    public void FireGCodeCommandHasComment(GCodeExecutionEvent evt)
    {
        for (Object obj : fEventListeners)
        {
            IGCodeExecutionEventListener listener = (IGCodeExecutionEventListener) obj;
            listener.GCodeExecutedWithError(evt);
        }
    }
    
}
