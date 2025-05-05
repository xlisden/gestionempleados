import { jsPDF } from "jspdf";

// Default export is a4 paper, portrait, using millimeters for units
const doc = new jsPDF();

doc.text("Hello world!", 10, 10);

document.getElementById("btnGenerar").addEventListener("click", function() {
    alert("Button clicked!");
    doc.save("a4.pdf");
});
// doc.save("a4.pdf");