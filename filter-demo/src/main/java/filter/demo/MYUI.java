package filter.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

@Push
@Route("")
public class MyUI extends VerticalLayout {
    TextField search = new TextField();
    Grid<Player> grid = new Grid();

    private Online_API_ReaderDao service = new OnlineAPIReaderDaoImpl();

    public MyUI() {
        Button remove = new Button(new Icon(VaadinIcon.CROSS_CUTLERY));
        HorizontalLayout layout = new HorizontalLayout(search, remove);

        search.setValueChangeMode(ValueChangeMode.EAGER);
        search.addValueChangeListener(e -> updateList());
        remove.addClickListener(e -> search.clear());

        grid.setSizeFull();
        grid.addColumn(Player::getPid).setHeader("Id");
        grid.addColumn(Player::getName).setHeader("Name");
        grid.addColumn(Player::getFullName).setHeader("Full Name");

        add(layout, grid);
        grid.setHeight("100vh");
    }

    void updateList() {
        grid.setItems(service.getPlayer(search.getValue()));
    }

}
