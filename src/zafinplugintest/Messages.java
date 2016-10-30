package zafinplugintest;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "zafinplugintest.messages"; //$NON-NLS-1$
	public static String ModelWizardPage_;
	public static String ModelWizardPage_Description;
	public static String ModelWizardPage_ModelType_Component;
	public static String ModelWizardPage_ModelType_Enum;
	public static String ModelWizardPage_ModelType_Model;
	public static String ModelWizardPage_Type;
	public static String ModelWizardPage_WizardName_Model;

	public static String ViewWizardPage_Description;
	public static String ViewWizardPage_Name;
	public static String ViewWizardPage_Type;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
