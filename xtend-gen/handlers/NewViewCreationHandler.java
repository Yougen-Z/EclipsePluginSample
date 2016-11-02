package handlers;

import handlers.AbstractNewArtifactCreationHandler;
import org.eclipse.jface.wizard.IWizard;
import zafinplugintest.NewViewWizard;

@SuppressWarnings("all")
public class NewViewCreationHandler extends AbstractNewArtifactCreationHandler {
  @Override
  protected final IWizard getWizard() {
    return new NewViewWizard();
  }
}
