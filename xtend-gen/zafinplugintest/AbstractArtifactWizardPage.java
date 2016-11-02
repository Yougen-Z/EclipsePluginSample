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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors(AccessorType.PUBLIC_GETTER)
@SuppressWarnings("all")
public abstract class AbstractArtifactWizardPage extends WizardPage {
  private String artifactType;
  
  private Text modelName;
  
  private StyledText description1;
  
  private Combo namespace;
  
  private String selectedDir = "C:/zplatform-develop/ws";
  
  private Text parentModel;
  
  public AbstractArtifactWizardPage(final String title, final String description, final String artifactType) {
    super(title);
    this.setTitle(title);
    this.setDescription(description);
    this.artifactType = artifactType;
  }
  
  @Override
  public void createControl(final Composite parent) {
    Composite container = new Composite(parent, SWT.NULL);
    GridLayout layout = new GridLayout(2, false);
    layout.marginWidth = 0;
    container.setLayout(layout);
    this.addNamespaceControl(container);
    this.addNameControl(container);
    this.addCustomControls(container);
    this.setControl(container);
    this.setPageComplete(false);
  }
  
  private void addNamespaceControl(final Composite container) {
    Label _label = new Label(container, SWT.NONE);
    _label.setText("Namespace");
    Combo _combo = new Combo(container, (SWT.DROP_DOWN | SWT.READ_ONLY));
    this.namespace = _combo;
    GridData _gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
    this.namespace.setLayoutData(_gridData);
    String[] items = { "C:/workspace/", "D:/workspace/", "E:/" };
    this.namespace.setItems(items);
    this.namespace.setEnabled(true);
  }
  
  private void addNameControl(final Composite container) {
    Label label1 = new Label(container, SWT.NONE);
    label1.setText("Name");
    Text _text = new Text(container, (SWT.BORDER | SWT.SINGLE));
    this.modelName = _text;
    this.modelName.setText("");
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
    GridData gd = new GridData(GridData.FILL_HORIZONTAL);
    this.modelName.setLayoutData(gd);
  }
  
  protected void addCustomControls(final Composite container) {
  }
  
  public void addDescriptionControl(final Composite container) {
    Label _label = new Label(container, SWT.NONE);
    _label.setText("Description");
    StyledText _styledText = new StyledText(container, 
      ((((SWT.MULTI | SWT.WRAP) | SWT.BORDER) | SWT.H_SCROLL) | SWT.V_SCROLL));
    this.description1 = _styledText;
    GridData _gridData = new GridData(GridData.FILL_BOTH);
    this.description1.setLayoutData(_gridData);
    this.description1.setText("Description for the model");
    final Function1<ModifyEvent, Object> _function = (ModifyEvent e) -> {
      return null;
    };
    this.description1.addModifyListener(((ModifyListener) new ModifyListener() {
        public void modifyText(ModifyEvent e) {
          _function.apply(e);
        }
    }));
  }
  
  public void addParentModelControl(final Composite container) {
    Label _label = new Label(container, SWT.NONE);
    _label.setText("Parent Model: ");
    Composite child = new Composite(container, SWT.FILL);
    RowLayout layout = new RowLayout();
    layout.marginWidth = 0;
    layout.marginHeight = 0;
    child.setLayout(layout);
    GridData _gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
    child.setLayoutData(_gridData);
    Text _text = new Text(child, SWT.NULL);
    this.parentModel = _text;
    Button button = new Button(child, SWT.PUSH);
    button.setText("Browse...");
    final Function1<Event, String> _function = (Event event) -> {
      String _xblockexpression = null;
      {
        Shell _shell = container.getShell();
        DirectoryDialog directoryDialog = new DirectoryDialog(_shell);
        directoryDialog.setFilterPath(this.selectedDir);
        directoryDialog.setMessage("directory message here");
        String dir = directoryDialog.open();
        String _xifexpression = null;
        if ((dir != null)) {
          String _xblockexpression_1 = null;
          {
            this.parentModel.setText(dir);
            _xblockexpression_1 = this.selectedDir = dir;
          }
          _xifexpression = _xblockexpression_1;
        }
        _xblockexpression = _xifexpression;
      }
      return _xblockexpression;
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
  public StyledText getDescription1() {
    return this.description1;
  }
  
  @Pure
  public Combo getNamespace() {
    return this.namespace;
  }
  
  @Pure
  public String getSelectedDir() {
    return this.selectedDir;
  }
  
  @Pure
  public Text getParentModel() {
    return this.parentModel;
  }
}
