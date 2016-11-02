package handlers;

import handlers.AbstractNewArtifactCreationHandler;
import org.eclipse.jface.wizard.IWizard;
import zafinplugintest.NewModelWizard;

@SuppressWarnings("all")
public class NewModelCreationHandler extends AbstractNewArtifactCreationHandler {
  @Override
  protected final IWizard getWizard() {
    return new NewModelWizard();
  }
}
