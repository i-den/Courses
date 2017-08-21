package project.bindingModel;

public class EntityBindingModel {
	@NotNull
    private String stringProperty;
	
	@NotNull
	private int intProperty;

	public String getStringProperty() {
		return this.title;
	}

	public void setStringProperty(String stringProperty) {
		this.stringProperty = stringProperty;
	}

	public int getIntProperty() {
		return this.intProperty;
	}

	public void setIntProperty(int intProperty) {
		this.intProperty = intProperty;
	}
}