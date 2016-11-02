package handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class AbstractNewArtifactCreationHandler extends AbstractHandler {
	
	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
		
        openWizard(getShell(event), getWizard());
        return null;
    }

	protected void openWizard(Shell shell, IWizard wizard) {
        new WizardDialog(shell, wizard).open();
    }

	protected Shell getShell(ExecutionEvent event) {
        return HandlerUtil.getActiveShell(event);
    }
	
	protected IWizard getWizard() {
		return null;
	}
}