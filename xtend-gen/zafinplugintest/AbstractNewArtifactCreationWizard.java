package zafinplugintest;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public abstract class AbstractNewArtifactCreationWizard extends Wizard implements INewWizard {
  private IWorkbench workbench;
  
  private IStructuredSelection selection;
  
  public AbstractNewArtifactCreationWizard() {
    super();
    this.setNeedsProgressMonitor(false);
  }
  
  @Override
  public void init(final IWorkbench workbench, final IStructuredSelection selection) {
    this.workbench = workbench;
    this.selection = selection;
  }
  
  @Override
  public boolean performFinish() {
    return true;
  }
  
  @Pure
  public IWorkbench getWorkbench() {
    return this.workbench;
  }
  
  public void setWorkbench(final IWorkbench workbench) {
    this.workbench = workbench;
  }
  
  @Pure
  public IStructuredSelection getSelection() {
    return this.selection;
  }
  
  public void setSelection(final IStructuredSelection selection) {
    this.selection = selection;
  }
}
