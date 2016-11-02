package zafinplugintest;

import com.zafin.plugin.extensionmethods.SWTLayoutExtensions;
import com.zafin.plugin.extensionmethods.SWTWidgetExtensions;
import java.util.Collections;
import java.util.List;
import org.eclipse.jface.wizard.IWizardContainer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public abstract class AbstractArtifactWizardPage extends WizardPage {
  private String artifactType;
  
  private Text modelName;
  
  private StyledText wizardDescription;
  
  private Combo namespace;
  
  private Text parentModel;
  
  private SWTWidgetExtensions swtWidgetExtensions = new SWTWidgetExtensions();
  
  public AbstractArtifactWizardPage(final String title, final String description, final String artifactType) {
    super(title);
    this.setTitle(title);
    this.setDescription(description);
    this.artifactType = artifactType;
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite child = SWTWidgetExtensions.addChildComposite(parent);
    GridLayout layout = SWTLayoutExtensions.newGridLayout(2, false);
    layout.marginWidth = 0;
    child.setLayout(layout);
    this.addNamespaceControl(child);
    this.addNameControl(child);
    this.addCustomControls(child);
    this.setControl(child);
    this.setPageComplete(false);
  }
  
  private void addNamespaceControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Namespace", SWT.NONE);
    List<String> items = Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("C:/workspace/", "D:/workspace/", "E:/"));
    final List<String> _converted_items = (List<String>)items;
    Combo _addCombo = SWTWidgetExtensions.addCombo(parent, ((String[])Conversions.unwrapArray(_converted_items, String.class)), (SWT.DROP_DOWN | SWT.READ_ONLY));
    this.namespace = _addCombo;
    GridData _newGridData = SWTLayoutExtensions.newGridData();
    this.namespace.setLayoutData(_newGridData);
  }
  
  private void addNameControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Name", SWT.NONE);
    Text _addText = SWTWidgetExtensions.addText(parent, "", (SWT.BORDER | SWT.SINGLE));
    this.modelName = _addText;
    GridData _newGridData = SWTLayoutExtensions.newGridData(GridData.FILL_HORIZONTAL);
    this.modelName.setLayoutData(_newGridData);
    this.modelName.addKeyListener(new KeyListener() {
      @Override
      public void keyPressed(final KeyEvent e) {
      }
      
      @Override
      public void keyReleased(final KeyEvent e) {
        String _text = AbstractArtifactWizardPage.this.modelName.getText();
        boolean _isEmpty = _text.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          AbstractArtifactWizardPage.this.setPageComplete(true);
        }
      }
    });
  }
  
  protected void addCustomControls(final Composite parent) {
  }
  
  public void addDescriptionControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Description", SWT.NONE);
    StyledText _addStyledText = SWTWidgetExtensions.addStyledText(parent, 
      "Description for the model", 
      ((((SWT.MULTI | SWT.WRAP) | SWT.BORDER) | SWT.H_SCROLL) | SWT.V_SCROLL));
    this.wizardDescription = _addStyledText;
    GridData _newGridData = SWTLayoutExtensions.newGridData(GridData.FILL_BOTH);
    this.wizardDescription.setLayoutData(_newGridData);
  }
  
  public void addParentModelControl(final Composite parent) {
    SWTWidgetExtensions.addLabel(parent, "Parent Model", SWT.NONE);
    Composite child = SWTWidgetExtensions.addChildComposite(parent, SWT.FILL);
    RowLayout _newRowLayout = SWTLayoutExtensions.newRowLayout();
    child.setLayout(_newRowLayout);
    GridData _newGridData = SWTLayoutExtensions.newGridData();
    child.setLayoutData(_newGridData);
    Text _addText = SWTWidgetExtensions.addText(child, SWT.NULL);
    this.parentModel = _addText;
    Button button = SWTWidgetExtensions.addButton(child, "Browse...", SWT.PUSH);
    final Procedure1<Event> _function = (Event event) -> {
      IWizardContainer _container = this.getContainer();
      Shell _shell = _container.getShell();
      DirectoryDialog directoryDialog = new DirectoryDialog(_shell);
      directoryDialog.setFilterPath("C:/zplatform-develop/ws");
      directoryDialog.setMessage("directory message here");
      String dir = directoryDialog.open();
      if ((dir != null)) {
        this.parentModel.setText(dir);
      }
    };
    button.addListener(SWT.Selection, ((Listener) new Listener() {
        public void handleEvent(Event event) {
          _function.apply(event);
        }
    }));
  }
  
  public void displayResult() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Model Name: ");
    String _text = this.modelName.getText();
    _builder.append(_text, "");
    String _string = _builder.toString();
    System.out.println(_string);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Model Namespace: ");
    String _text_1 = this.namespace.getText();
    _builder_1.append(_text_1, "");
    String _string_1 = _builder_1.toString();
    System.out.println(_string_1);
  }
  
  @Pure
  public String getArtifactType() {
    return this.artifactType;
  }
  
  @Pure
  public Text getModelName() {
    return this.modelName;
  }
  
  @Pure
  public StyledText getWizardDescription() {
    return this.wizardDescription;
  }
  
  @Pure
  public Combo getNamespace() {
    return this.namespace;
  }
  
  @Pure
  public Text getParentModel() {
    return this.parentModel;
  }
  
  @Pure
  public SWTWidgetExtensions getSwtWidgetExtensions() {
    return this.swtWidgetExtensions;
  }
}
