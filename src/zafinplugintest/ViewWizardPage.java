package zafinplugintest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ViewWizardPage extends AbstractWizardPage {

	public ViewWizardPage(String pageName) {
    	super(pageName);
        setTitle("Create a new view");
        setDescription("Model name is required");
    }

    @Override
    public void createControl(Composite parent) {
    		Composite container = new Composite(parent, SWT.NONE);
            GridLayout layout = new GridLayout();
            container.setLayout(layout);
            layout.numColumns = 2;

            Label label5 = new Label(container, SWT.NONE);
            label5.setText("Description");
            StyledText descriptionInput = new StyledText(
            		container,
            		SWT.MULTI
            			| SWT.WRAP
            			| SWT.BORDER
            			| SWT.H_SCROLL
            			| SWT.V_SCROLL);
            
            descriptionInput.setLayoutData(new GridData(GridData.FILL_BOTH));
            descriptionInput.setText("Description for the model");
            descriptionInput.addModifyListener(new ModifyListener() {
    			@Override
    			public void modifyText(ModifyEvent e) {
    				setPageComplete(true);
    			}
    		});
            
            // required to avoid an error in the system
            setControl(container);
            setPageComplete(false);
    }
}
