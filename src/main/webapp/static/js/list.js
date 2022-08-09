document.addEventListener("DOMContentLoaded", () => {
  const memo_table = document.querySelector("table.hs_container");

  memo_table?.addEventListener("click", (e) => {
    const td = e.target;
    const clk = e.target;

    if (td.className === "able") {
      const tr = td.closest("TR");
      const seq = tr.dataset.seq;
      if (seq) {
        document.location.href = `${rootPath}/${seq}/update`;
      }
    }
    if (clk.tagName === "BUTTON") {
      const td = clk.closest("TR");
      const seq = td.dataset.seq;
      if (seq) {
        document.location.href = `${rootPath}/${seq}/done`;
      }
    }
  }); //end memo_table
});
