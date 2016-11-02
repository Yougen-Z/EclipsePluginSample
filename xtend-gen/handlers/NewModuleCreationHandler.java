package handlers;

import handlers.AbstractNewArtifactCreationHandler;
import org.eclipse.jface.wizard.IWizard;
import zafinplugintest.NewModuleWizard;

@SuppressWarnings("all")
public class NewModuleCreationHandler extends AbstractNewArtifactCreationHandler {
  @Override
  protected final IWizard getWizard() {
    return new NewModuleWizard();
  }
}
