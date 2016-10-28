package zafinplugintest;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ModelWizardPage extends AbstractWizardPage {
	private Composite container;
	private Text modelName;
	private StyledText description;
	private Combo modelType;
	private String selectedDir = "C:/zplatform-develop/ws";

	public ModelWizardPage(String pageName) {
        super(pageName);
        setTitle("Create new Model");
        setDescription("Model name is required");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        container.setLayout(layout);
        layout.numColumns = 2;
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
        
        Label label2 = new Label(container, SWT.NONE);
        label2.setText("Parent Model: ");
        Group mg = new Group(container, SWT.NULL);
        mg.setSize(600,30);
        Text modelDir = new Text(mg, SWT.NULL);
        modelDir.setBounds(0, 10, 350, 25);
        Button button = new Button(mg, SWT.PUSH);
        button.setBounds(380, 10, 100, 25);
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

        Label label3 = new Label(container, SWT.NONE);
        label3.setText("Model Type");
        modelType = new Combo(container, SWT.DROP_DOWN | SWT.READ_ONLY);
        modelType.setBounds(50, 50, 350, 65);
        String items[] = {"Model", "Component", "Enum"};
        modelType.setItems(items);
        modelType.setEnabled(true);
        
        Label label4 = new Label(container, SWT.NONE);
        label4.setText("Modifier:");
        Group modifiers = new Group(container, SWT.NULL);
        modifiers.setSize(630, 175);
        Button m1 = new Button(modifiers, SWT.RADIO);
        m1.setText("Model");
        m1.setBounds(10, 10, 75, 15);
        Button m2 = new Button(modifiers, SWT.RADIO);
        m2.setText("Enum");
        m2.setBounds(86, 10, 75, 15);
        Button m3 = new Button(modifiers, SWT.RADIO);
        m3.setText("Component");
        m3.setBounds(160, 10, 85, 15);
        modifiers.pack();
        
        Label label5 = new Label(container, SWT.NONE);
        label5.setText("Description");
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
        
        
        // required to avoid an error in the system
        setControl(container);
        setPageComplete(false);
	}
	
	public void displayResult() {
		System.out.println("Model Name: " + modelName.getText());
		System.out.println("Model Type: " + modelType.getText());
		System.out.println("Modifier: " );
		System.out.println("Model directory: " + selectedDir);
		System.out.println("Description: " + description.getText());
	}
}
