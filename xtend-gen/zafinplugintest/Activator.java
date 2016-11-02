package zafinplugintest;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("all")
public class Activator extends AbstractUIPlugin {
  public final static String PLUGIN_ID = "ZafinPluginTest";
  
  private static Activator plugin;
  
  /**
   * The constructor
   */
  public Activator() {
  }
  
  /**
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
   */
  @Override
  public void start(final BundleContext context) throws Exception {
    super.start(context);
    Activator.plugin = this;
  }
  
  /**
   * (non-Javadoc)
   * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
   */
  @Override
  public void stop(final BundleContext context) throws Exception {
    Activator.plugin = null;
    super.stop(context);
  }
  
  /**
   * Returns the shared instance
   * @return the shared instance
   */
  public static Activator getDefault() {
    return Activator.plugin;
  }
}
