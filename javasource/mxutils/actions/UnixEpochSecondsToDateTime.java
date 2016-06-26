// This file was generated by Mendix Modeler.
//
// WARNING: Only the following code will be retained when actions are regenerated:
// - the import list
// - the code between BEGIN USER CODE and END USER CODE
// - the code between BEGIN EXTRA CODE and END EXTRA CODE
// Other code you write will be lost the next time you deploy the project.
// Special characters, e.g., é, ö, à, etc. are supported in comments.

package mxutils.actions;

import com.mendix.systemwideinterfaces.core.IContext;
import com.mendix.webui.CustomJavaAction;
import java.util.Date;

/**
 * Convert unix epoch timestamp to DateTime
 */
public class UnixEpochSecondsToDateTime extends CustomJavaAction<java.util.Date>
{
	private Long UnixEpoch;

	public UnixEpochSecondsToDateTime(IContext context, Long UnixEpoch)
	{
		super(context);
		this.UnixEpoch = UnixEpoch;
	}

	@Override
	public java.util.Date executeAction() throws Exception
	{
		// BEGIN USER CODE
		Date date = new Date(this.UnixEpoch * 1000);
		return date;
		// END USER CODE
	}

	/**
	 * Returns a string representation of this action
	 */
	@Override
	public String toString()
	{
		return "UnixEpochSecondsToDateTime";
	}

	// BEGIN EXTRA CODE
	// END EXTRA CODE
}
