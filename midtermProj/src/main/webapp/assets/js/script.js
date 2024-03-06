
if (result == 1) {
    response.sendRedirect("list");
} else {
    response.sendRedirect("join?result=fail");
}