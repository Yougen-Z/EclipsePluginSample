package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import zafinplugintest.NewModuleWizard;

public class NewModuleCreationHandler extends AbstractNewCreationHandler {

	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
		
        openWizard(getShell(event), new NewModuleWizard());
        return null;
    }

}
