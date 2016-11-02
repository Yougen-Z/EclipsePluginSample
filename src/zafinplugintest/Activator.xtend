package zafinplugintest

import org.eclipse.ui.plugin.AbstractUIPlugin
import org.osgi.framework.BundleContext

/** 
 * The activator class controls the plug-in life cycle
 */
class Activator extends AbstractUIPlugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "ZafinPluginTest"
	// $NON-NLS-1$
	// The shared instance
	static Activator plugin

	/** 
	 * The constructor
	 */
	new() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	override void start(BundleContext context) throws Exception {
		super.start(context)
		plugin = this
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	override void stop(BundleContext context) throws Exception {
		plugin = null
		super.stop(context)
	}

	/** 
	 * Returns the shared instance
	 * @return the shared instance
	 */
	def static Activator getDefault() {
		plugin
	}

}
