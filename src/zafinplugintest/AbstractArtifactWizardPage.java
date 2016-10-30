package zafinplugintest;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public abstract class AbstractArtifactWizardPage extends WizardPage {
	private String artifactType;
	private Text modelName;
	private StyledText description;
	private Combo modelType;
	private String selectedDir = "C:/zplatform-develop/ws";

	public AbstractArtifactWizardPage(String title,
									  String description,
									  String artifactType) {
		super(title);
		setTitle(title);
		setDescription(description);
        this.artifactType = artifactType;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
        GridLayout layout = new GridLayout(2, false);
        layout.marginWidth = 0;
        container.setLayout(layout);

        addNamespaceControl(container);
        addNameControl(container);        
        addCustomControls(container);
        
        setControl(container);
        setPageComplete(false);
	}

	private void addNamespaceControl(Composite container) {
    	new Label(container, SWT.NONE).setText("Namespace");
        modelType = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        modelType.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
        String items[] = {"C:/workspace/", "D:/workspace/", "E:/"};
        modelType.setItems(items);
        modelType.setEnabled(true);
	}

	private void addNameControl(Composite container) {
		Label label1 = new Label(container, SWT.NONE);
        label1.setText("Name");

        modelName = new Text(container, SWT.BORDER | SWT.SINGLE);
        modelName.setText("");
        modelName.addKeyListener(new KeyListener() {

                @Override
                public void keyPressed(KeyEvent e) {
                }

                @Override
                public void keyReleased(KeyEvent e) {
                        if (!modelName.getText().isEmpty()) {
                                setPageComplete(true);
                        }
                }
        });
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        modelName.setLayoutData(gd);
	}
        
    protected void addCustomControls(Composite container) {
		// subclasses can add more controls through this method
		
	}

	public void addDescriptionControl(Composite container) {
    	new Label(container, SWT.NONE).setText("Description");
        
        description = new StyledText(
        		container,
        		SWT.MULTI
        			| SWT.WRAP
        			| SWT.BORDER
        			| SWT.H_SCROLL
        			| SWT.V_SCROLL);
        description.setLayoutData(new GridData(GridData.FILL_BOTH));
        description.setText("Description for the model");
        description.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
			}
		});
	}
	
	public void addParentModelControl (Composite container) {
		new Label(container, SWT.NONE).setText("Parent Model: ");
		
		Composite child = new Composite(container, SWT.FILL);
		RowLayout layout = new RowLayout();
		layout.marginWidth = 0;
		layout.marginHeight = 0;
        child.setLayout(layout);
        child.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

        Text modelDir = new Text(child, SWT.NULL);
        Button button = new Button(child, SWT.PUSH);
        button.setText("Browse...");
        button.addListener(SWT.Selection, new Listener(){
        	public void handleEvent(Event event) {
        		DirectoryDialog directoryDialog = new DirectoryDialog(container.getShell());
        		
        		directoryDialog.setFilterPath(selectedDir);
        		directoryDialog.setMessage("directory message here");
        		
        		String dir = directoryDialog.open();
        		if(dir != null) {
        			modelDir.setText(dir);
        			selectedDir = dir;
        		}
        	}
        });
	}

	public void displayResult() {
		System.out.println("Model Name: " + modelName.getText());
		System.out.println("Model Type: " + modelType.getText());
	}
}
