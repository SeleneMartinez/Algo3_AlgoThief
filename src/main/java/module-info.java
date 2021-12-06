module edu.fiuba.algo3 {
    requires javafx.controls;
    exports edu.fiuba.algo3;
    requires javafx.graphics;
    requires com.google.gson;
    exports edu.fiuba.algo3.modelo;
    opens edu.fiuba.algo3.modelo;
}