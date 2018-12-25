package my.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import my.demo.Models.Model;

import java.util.Set;

@Route("")
public class Mainview extends VerticalLayout {
    private ApiReaderDao service = new ApiReaderImplement();

    HorizontalLayout dividerLayout = new HorizontalLayout();
    HorizontalLayout topper = new HorizontalLayout();
    VerticalLayout detailsLayout = new VerticalLayout();
    Model model = new Model();

    Grid<Model> grid = new Grid();
    TextField search = new TextField();
    Button removeButton = new Button(new Icon(VaadinIcon.CROSS_CUTLERY));
    Button select = new Button(new Icon(VaadinIcon.ANCHOR));

    Image image = new Image();
    Label name = new Label("Name : ");
    Label age = new Label("Age : ");


    public Mainview() {
        removeButton.addClickListener(e -> search.clear());
        topper.add(search, removeButton);
        add(topper);

        search.setValueChangeMode(ValueChangeMode.EAGER);
        search.addValueChangeListener(e -> updateList());

        dividerLayout.add(detailsLayout);
        //image.setSrc(model.getImageUrl());
        detailsLayout.add(name, age);

        grid.setSizeFull();
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.addColumn(Model::getPid).setHeader("Id");

        grid.addColumn(Model::getFullName).setHeader("Full Name");
        grid.addColumn(Model::getName).setHeader("Name");
        grid.setHeight("50vh");

        select.addClickListener(ClickEvent -> {
            Set<Model> selectedItems = grid.getSelectedItems();

            for (Model playerDetails : selectedItems) {
                int getPlayerId = playerDetails.getPid();
                name.setText(playerDetails.getFullName());
                // age.setText(service.getPlayerDetails(id));
            }
        });

        add(dividerLayout, grid, select);
    }

    private void updateList() {
        grid.setItems(service.getPlayer(search.getValue()));
    }
}
