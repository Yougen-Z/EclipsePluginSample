package handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

@SuppressWarnings("all")
public abstract class AbstractNewArtifactCreationHandler extends AbstractHandler {
  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    Object _xblockexpression = null;
    {
      Shell _shell = this.getShell(event);
      IWizard _wizard = this.getWizard();
      this.openWizard(_shell, _wizard);
      _xblockexpression = null;
    }
    return _xblockexpression;
  }
  
  protected void openWizard(final Shell shell, final IWizard wizard) {
    WizardDialog _wizardDialog = new WizardDialog(shell, wizard);
    _wizardDialog.open();
  }
  
  protected Shell getShell(final ExecutionEvent event) {
    return HandlerUtil.getActiveShell(event);
  }
  
  protected IWizard getWizard() {
    return null;
  }
}
