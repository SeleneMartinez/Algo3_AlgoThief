module edu.fiuba.algo3 {
    requires javafx.controls;
    exports edu.fiuba.algo3;
    requires javafx.graphics;
    exports edu.fiuba.algo3.modelo;
    opens edu.fiuba.algo3.modelo;
}