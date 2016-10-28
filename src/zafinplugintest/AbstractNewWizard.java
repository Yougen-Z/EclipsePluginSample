package zafinplugintest;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

public class AbstractNewWizard extends Wizard implements INewWizard {

	public AbstractNewWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	@Override
	public String getWindowTitle() {
		return "New Wizard Creation";
	}
	
	@Override
	public void addPages() {
		super.addPages();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		
	}

	@Override
	public boolean performFinish() {
		
		return false;
	}

}
