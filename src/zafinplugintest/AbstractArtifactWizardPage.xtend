package zafinplugintest

import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.events.KeyEvent
import org.eclipse.swt.events.KeyListener
import org.eclipse.swt.events.ModifyEvent
import org.eclipse.swt.events.ModifyListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.layout.GridLayout
import org.eclipse.swt.layout.RowLayout
import org.eclipse.swt.widgets.Button
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.swt.widgets.Event
import org.eclipse.swt.widgets.Label
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors

@Accessors(PUBLIC_GETTER) abstract class AbstractArtifactWizardPage extends WizardPage {
	private String artifactType
	private Text modelName
	private StyledText description1
	private Combo namespace
	private String selectedDir = "C:/zplatform-develop/ws"
	private Text parentModel

	new(String title, String description, String artifactType) {
		super(title)
		setTitle(title)
		setDescription(description)
		this.artifactType = artifactType
	}

	override void createControl(Composite parent) {
		var container = new Composite(parent, SWT::NULL)
		var layout = new GridLayout(2, false)
		layout.marginWidth = 0
		container.setLayout(layout)
		addNamespaceControl(container)
		addNameControl(container)
		addCustomControls(container)
		setControl(container)
		setPageComplete(false)
	}

	def private void addNamespaceControl(Composite container) {
		new Label(container, SWT::NONE).setText("Namespace")
		namespace = new Combo(container, SWT::DROP_DOWN.bitwiseOr(SWT::READ_ONLY))
		namespace.setLayoutData(new GridData(SWT::FILL, SWT::BEGINNING, true, false))
		var String[] items = #["C:/workspace/", "D:/workspace/", "E:/"]
		namespace.setItems(items)
		namespace.setEnabled(true)
	}

	def private void addNameControl(Composite container) {
		var label1 = new Label(container, SWT::NONE)
		label1.setText("Name")
		modelName = new Text(container, SWT::BORDER.bitwiseOr(SWT::SINGLE))
		modelName.setText("")
		modelName.addKeyListener(new KeyListener() {
			override void keyPressed(KeyEvent e) {
			}

			override void keyReleased(KeyEvent e) {
				if (!modelName.getText().isEmpty()) {
					setPageComplete(true)
				}

			}
		})
		var gd = new GridData(GridData::FILL_HORIZONTAL)
		modelName.setLayoutData(gd)
	}

	def protected void addCustomControls(Composite container) {
		// subclasses can add more controls through this method
	}

	def void addDescriptionControl(Composite container) {
		new Label(container, SWT::NONE).setText("Description")
		description1 = new StyledText(container,
			SWT::MULTI.bitwiseOr(SWT::WRAP).bitwiseOr(SWT::BORDER).bitwiseOr(SWT::H_SCROLL).bitwiseOr(SWT::V_SCROLL))
		description1.setLayoutData(new GridData(GridData::FILL_BOTH))
		description1.setText("Description for the model")
		description1.addModifyListener(([ModifyEvent e|] as ModifyListener))
	}

	def void addParentModelControl(Composite container) {
		new Label(container, SWT::NONE).setText("Parent Model: ")
		var child = new Composite(container, SWT::FILL)
		var layout = new RowLayout()
		layout.marginWidth = 0
		layout.marginHeight = 0
		child.setLayout(layout)
		child.setLayoutData(new GridData(SWT::FILL, SWT::BEGINNING, true, false))
		parentModel = new Text(child, SWT::NULL)
		var Button button = new Button(child, SWT::PUSH)
		button.setText("Browse...")
		button.addListener(SWT::Selection,([ Event event |
			var directoryDialog = new DirectoryDialog(container.getShell())
			directoryDialog.setFilterPath(selectedDir)
			directoryDialog.setMessage("directory message here")
			var dir = directoryDialog.open()
			if (dir !== null) {
				parentModel.setText(dir)
				selectedDir = dir
			}
		] as Listener))
	}

	def void displayResult() {
		System::out.println('''Model Name: «modelName.text»'''.toString)
		System::out.println('''Model Namespace: «namespace.text»'''.toString)
	}

}
