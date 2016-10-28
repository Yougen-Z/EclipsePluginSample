package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import zafinplugintest.NewViewWizard;

public class NewViewCreationHandler extends AbstractNewArtifactCreationHandler {

	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
		
        openWizard(getShell(event), new NewViewWizard());
        return null;
    }
}
