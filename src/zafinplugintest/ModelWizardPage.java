package zafinplugintest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class ModelWizardPage extends AbstractArtifactWizardPage {
	private Combo modelType;
	Group modifiers;

	public ModelWizardPage() {
		super(Messages.ModelWizardPage_WizardName_Model, Messages.ModelWizardPage_Description, Messages.ModelWizardPage_);
	}

	@Override
	protected void addCustomControls(Composite container) {
		addModelTypeControl(container);
		addModifiersControl(container);
        addParentModelControl(container);
	}
	
	private void addModelTypeControl(Composite container) {
		new Label(container, SWT.NONE).setText(Messages.ModelWizardPage_Type);
        modelType = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        modelType.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        String items[] = {Messages.ModelWizardPage_ModelType_Model
        		, Messages.ModelWizardPage_ModelType_Component
        		, Messages.ModelWizardPage_ModelType_Enum};
        modelType.setItems(items);
        modelType.setEnabled(true);
	}
	
	private void addModifiersControl(Composite container) {
		new Label(container, SWT.NONE).setText("Modifier:");
		
		GridLayout layout = new GridLayout(3, true);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		
        modifiers = new Group(container, SWT.NULL);
        modifiers.setLayout(layout);
        modifiers.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        
        Button m1 = new Button(modifiers, SWT.RADIO);
        m1.setText("Model");
        Button m2 = new Button(modifiers, SWT.RADIO);
        m2.setText("Enum");
        Button m3 = new Button(modifiers, SWT.RADIO);
        m3.setText("Component");
        modifiers.pack();
	}
	
	@Override
	public void displayResult() {
		super.displayResult();
		System.out.println("Model Type: " + modelType.getText());
		System.out.println("Modifier: " + modifiers.getText());
		System.out.println("Model Type" + modelType.getText());
	}
}
