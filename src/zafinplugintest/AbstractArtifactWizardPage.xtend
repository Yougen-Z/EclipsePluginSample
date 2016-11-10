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
import org.eclipse.swt.widgets.Label

@Accessors(PUBLIC_GETTER) abstract class AbstractArtifactWizardPage extends WizardPage {
	private Text modelName
	private StyledText wizardDescription
	private Combo namespace
	private Text parentModel
	
	new(String title, String description) {
		
		super(title)
		this.title = title
		this.description = description
	}

	override void createControl(Composite parent) {
		val nclo = 2 // numColumns
		val mwidth = 0 //marginWidth
		
		parent.addChildComposite => [
			layout = newGridLayout => [
			numColumns = nclo
			makeColumnsEqualWidth = false
			marginWidth = mwidth
			]
			
			addNamespaceControl
			addNameControl
			addCustomControls
			createLine(nclo)
			addOpenInEditorCheckbox
			
			setControl
		]		
		pageComplete = false
	}

	def private void addNamespaceControl(Composite parent) {		
		val items = #["C:/workspace/", "D:/workspace/", "E:/"]
		
		parent => [
			addLabel("Namespace", SWT.NONE)
			namespace = addCombo(items, SWT::DROP_DOWN.bitwiseOr(SWT::READ_ONLY)) => [
				layoutData = newGridData
			]
		]
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
		
		parent.addChildComposite(SWT::FILL) => [			
			layout = newGridLayout
			layoutData = newGridData
			parentModel = addText(SWT::NULL)
			addButton("Browse...", SWT::PUSH) => [
				addListener(SWT::Selection,([ Event event |
					var directoryDialog = new DirectoryDialog(container.shell)
					directoryDialog.filterPath = "C:/zplatform-develop/ws"
					directoryDialog.message = "directory message here"
					var dir = directoryDialog.open()
					if (dir !== null) {
						parentModel.text = dir
					}
				] as Listener))
			]
		]
//		var button = child.addButton("Browse...", SWT::PUSH)		
//		button.addListener(SWT::Selection,([ Event event |
//			var directoryDialog = new DirectoryDialog(container.shell)
//			directoryDialog.filterPath = "C:/zplatform-develop/ws"
//			directoryDialog.message = "directory message here"
//			var dir = directoryDialog.open()
//			if (dir !== null) {
//				parentModel.text = dir
//			}
//		] as Listener))
	}

	def void addOpenInEditorCheckbox(Composite parent) {
		parent.addButton(SWT::CHECK) => [
			text = "Open artifact in editor"
			selection = true
		]
	}
	
	def void createLine(Composite parent, int ncol) 
	{
		parent.addLabel(SWT::SEPARATOR
			.bitwiseOr(SWT::HORIZONTAL)
			.bitwiseOr(SWT::BOLD)) => [
				
			layoutData = newGridData(GridData.FILL_HORIZONTAL) => [
				horizontalSpan = ncol
			]
		]
	}

	def void displayResult() {
		
		System::out.println('''Model Name: «modelName.text»'''.toString)
		System::out.println('''Model Namespace: «namespace.text»'''.toString)
	}
}
