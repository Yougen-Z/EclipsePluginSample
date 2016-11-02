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
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions
import com.zafin.plugin.extensionmethods.SWTLayoutExtensions

@Accessors(PUBLIC_GETTER) abstract class AbstractArtifactWizardPage extends WizardPage {
	private String artifactType
	private Text modelName
	private StyledText wizardDescription
	private Combo namespace
	private Text parentModel
	
	private SWTWidgetExtensions swtWidgetExtensions = new SWTWidgetExtensions()

	new(String title, String description, String artifactType) {
		
		super(title)
		this.title = title
		this.description = description
		this.artifactType = artifactType
	}

	override void createControl(Composite parent) {
		
		var child = SWTWidgetExtensions.addChildComposite(parent)
		var layout = SWTLayoutExtensions.newGridLayout(2, false)
		layout.marginWidth = 0
		child.setLayout(layout)
		addNamespaceControl(child)
		addNameControl(child)
		addCustomControls(child)
		setControl(child)
		setPageComplete(false)
	}

	def private void addNamespaceControl(Composite parent) {
		
		SWTWidgetExtensions.addLabel(parent, "Namespace", SWT.NONE)
		var items = #["C:/workspace/", "D:/workspace/", "E:/"]
		namespace = SWTWidgetExtensions.addCombo(parent, items, SWT::DROP_DOWN.bitwiseOr(SWT::READ_ONLY))
		namespace.layoutData = SWTLayoutExtensions.newGridData
	}

	def private void addNameControl(Composite parent) {
		
		SWTWidgetExtensions.addLabel(parent, "Name", SWT.NONE)
		modelName = SWTWidgetExtensions.addText(parent, "", SWT::BORDER.bitwiseOr(SWT::SINGLE))
		modelName.layoutData = SWTLayoutExtensions.newGridData(GridData::FILL_HORIZONTAL)
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
		
		SWTWidgetExtensions.addLabel(parent, "Description", SWT.NONE)
		wizardDescription = SWTWidgetExtensions.addStyledText(parent, 
						"Description for the model", 
						SWT::MULTI
							.bitwiseOr(SWT::WRAP)
							.bitwiseOr(SWT::BORDER)
							.bitwiseOr(SWT::H_SCROLL)
							.bitwiseOr(SWT::V_SCROLL))
		wizardDescription.layoutData = SWTLayoutExtensions.newGridData(GridData::FILL_BOTH)
	}

	def void addParentModelControl(Composite parent) {
		
		SWTWidgetExtensions.addLabel(parent, "Parent Model", SWT.NONE)
		
		var child = SWTWidgetExtensions.addChildComposite(parent, SWT::FILL)
		child.layout = SWTLayoutExtensions.newRowLayout
		child.layoutData = SWTLayoutExtensions.newGridData
		
		parentModel = SWTWidgetExtensions.addText(child, SWT::NULL)
		var button = SWTWidgetExtensions.addButton(child, "Browse...", SWT::PUSH)		
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
