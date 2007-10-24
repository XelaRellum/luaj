/*******************************************************************************
* Copyright (c) 2007 LuaJ. All rights reserved.
*
* Permission is hereby granted, free of charge, to any person obtaining a copy
* of this software and associated documentation files (the "Software"), to deal
* in the Software without restriction, including without limitation the rights
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
* copies of the Software, and to permit persons to whom the Software is
* furnished to do so, subject to the following conditions:
*
* The above copyright notice and this permission notice shall be included in
* all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
* THE SOFTWARE.
******************************************************************************/
package lua.debug.event;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class DebugEventError extends DebugEvent {
    protected String detail;
    
    public DebugEventError(String detail) {
        super(DebugEventType.error);
        this.detail = detail;
    }
    
    public String getDetail() {
        return this.detail;
    }

    /* (non-Javadoc)
     * @see lua.debug.DebugEvent#toString()
     */
    public String toString() {
        return super.toString() + " detail: " + getDetail();
    }
    
    public static void serialize(DataOutputStream out, DebugEventError object) 
    throws IOException {
    	out.writeUTF(object.getDetail());
	}

	public static DebugEvent deserialize(DataInputStream in) throws IOException {
		String detail = in.readUTF();
		return new DebugEventError(detail);
	}
}
