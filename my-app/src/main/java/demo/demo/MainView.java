package demo.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import demo.demo.model.Customer;
import demo.demo.model.CustomerService;

@Route("")
public class MainView extends VerticalLayout {
    private CustomerService service = CustomerService.getInstance();
    private Grid<Customer> grid = new Grid<>();
    private TextField filterText = new TextField();


    public MainView() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());

        Button clearFilterTextBtn = new Button(
                new Icon(VaadinIcon.CLOSE_CIRCLE));
        clearFilterTextBtn.addClickListener(e -> filterText.clear());

        HorizontalLayout filtering = new HorizontalLayout(filterText,
                clearFilterTextBtn);
        add(filtering);

        grid.setSizeFull();

        grid.addColumn(Customer::getFirstName).setHeader("First name");
        grid.addColumn(Customer::getLastName).setHeader("Last name");
        grid.addColumn(Customer::getStatus).setHeader("Status");

        add(grid);
        setHeight("100vh");
        updateList();
    }

    private void updateList() {
        grid.setItems(service.findAll(filterText.getValue()));
    }
}

