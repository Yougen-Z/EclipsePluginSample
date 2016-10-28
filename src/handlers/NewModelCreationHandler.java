package handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import zafinplugintest.NewModelWizard;

public class NewModelCreationHandler extends AbstractNewCreationHandler {

	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
		
        openWizard(getShell(event), new NewModelWizard());
        return null;
    }

}
