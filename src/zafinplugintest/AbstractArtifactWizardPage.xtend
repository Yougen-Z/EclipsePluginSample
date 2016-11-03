package zafinplugintest

import org.eclipse.jface.wizard.WizardPage
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.StyledText
import org.eclipse.swt.events.KeyEvent
import org.eclipse.swt.events.KeyListener
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Combo
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.DirectoryDialog
import org.eclipse.swt.widgets.Event
import org.eclipse.swt.widgets.Listener
import org.eclipse.swt.widgets.Text
import org.eclipse.xtend.lib.annotations.Accessors
import static extension com.zafin.plugin.extensionmethods.SWTWidgetExtensions.*
import static extension com.zafin.plugin.extensionmethods.SWTLayoutExtensions.*

@Accessors(PUBLIC_GETTER) abstract class AbstractArtifactWizardPage extends WizardPage {
	private String artifactType
	private Text modelName
	private StyledText wizardDescription
	private Combo namespace
	private Text parentModel
	

	new(String title, String description, String artifactType) {
		
		super(title)
		this.title = title
		this.description = description
		this.artifactType = artifactType
	}

	override void createControl(Composite parent) {
		
		var child = parent.addChildComposite
		var layout = 2.newGridLayout(false)
		layout.marginWidth = 0
		child.layout = layout
		child.addNamespaceControl
		child.addNameControl
		child.addCustomControls
		child.setControl
		pageComplete = false
	}

	def private void addNamespaceControl(Composite parent) {
		
		parent.addLabel("Namespace", SWT.NONE)
		var items = #["C:/workspace/", "D:/workspace/", "E:/"]
		namespace = parent.addCombo(items, SWT::DROP_DOWN.bitwiseOr(SWT::READ_ONLY))
		namespace.layoutData = newGridData
	}

	def private void addNameControl(Composite parent) {
		
		parent.addLabel("Name", SWT.NONE)
		modelName = parent.addText("", SWT::BORDER.bitwiseOr(SWT::SINGLE))
		modelName.layoutData = GridData::FILL_HORIZONTAL.newGridData
		modelName.addKeyListener(new KeyListener() {
			override void keyPressed(KeyEvent e) {
			}

			override void keyReleased(KeyEvent e) {
				if (!modelName.text.isEmpty()) {
					pageComplete = true
				}
			}
		})
	}

	def protected void addCustomControls(Composite parent) {
		// subclasses can add more controls through this method
	}

	def void addDescriptionControl(Composite parent) {
		
		parent.addLabel("Description", SWT.NONE)
		wizardDescription = parent.addStyledText(
						"Description for the model", 
						SWT::MULTI
							.bitwiseOr(SWT::WRAP)
							.bitwiseOr(SWT::BORDER)
							.bitwiseOr(SWT::H_SCROLL)
							.bitwiseOr(SWT::V_SCROLL))
		wizardDescription.layoutData = GridData::FILL_BOTH.newGridData
	}

	def void addParentModelControl(Composite parent) {
		
		parent.addLabel("Parent Model", SWT.NONE)
		
		var child = parent.addChildComposite(SWT::FILL)
		child.layout = newRowLayout
		child.layoutData = newGridData
		
		parentModel = child.addText(SWT::NULL)
		var button = child.addButton("Browse...", SWT::PUSH)		
		button.addListener(SWT::Selection,([ Event event |
			var directoryDialog = new DirectoryDialog(container.shell)
			directoryDialog.filterPath = "C:/zplatform-develop/ws"
			directoryDialog.message = "directory message here"
			var dir = directoryDialog.open()
			if (dir !== null) {
				parentModel.text = dir
			}
		] as Listener))
	}

	def void displayResult() {
		
		System::out.println('''Model Name: «modelName.text»'''.toString)
		System::out.println('''Model Namespace: «namespace.text»'''.toString)
	}
}
