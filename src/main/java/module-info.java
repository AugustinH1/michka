module michka {
    requires javafx.controls;
    requires jakarta.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens Entity to org.hibernate.orm.core;

    exports Graphics;

}