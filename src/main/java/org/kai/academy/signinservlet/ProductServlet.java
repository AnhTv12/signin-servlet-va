package org.kai.academy.signinservlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.kai.academy.signinservlet.model.Product;
import org.kai.academy.signinservlet.utils.HibernateUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "TestServlet", value = "/1")
public class ProductServlet extends HttpServlet {
    Session session;

    @Override
    public void init() throws ServletException {
        session = HibernateUtil.getSessionFactory().openSession();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
        Root<Product> root = criteriaQuery.from(Product.class);
        criteriaQuery.select(root);
        List<Product> productList = session.createQuery(criteriaQuery).getResultList();
        PrintWriter out = response.getWriter();


        out.println("<head>                                                                                                                                         ");
        out.println("    <meta charset=\"UTF-8\">                                                                                                                     ");
        out.println("    <title>Signin</title>                                                                                                                      ");
        out.println("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css\">                                  ");
        out.println("    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css\">                                     ");
        out.println("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>");
        out.println("    <style>                                                                                                                                    ");
        out.println("html {\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        body{\n" +
                "            background-image: url(\"https://www.hostinger.vn/huong-dan/wp-content/uploads/sites/10/2019/01/huong-dan-thiet-ke-website.jpg\");\n" +
                "        }\n" +
                "\n" +
                "        .container {\n" +
                "            width: 100%;\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "        }\n" +
                "\n" +
                "        .btn-login {\n" +
                "            font-size: 0.9rem;\n" +
                "            letter-spacing: 0.05rem;\n" +
                "            padding: 0.75rem 1rem;\n" +
                "        }\n" +
                "\n" +
                "        .product-container {\n" +
                "            display: flex;\n" +
                "            flex-wrap: wrap;\n" +
                "            justify-content: space-between;\n" +
                "            gap: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .card {\n" +
                "            width: 30%;\n" +
                "            display: flex;\n" +
                "            flex-direction: column;\n" +
                "            justify-content: space-around;\n" +
                "            text-decoration: none;\n" +
                "            border: solid 0.5px rgb(6, 84, 87);\n" +
                "        }\n" +
                "\n" +
                "        img {\n" +
                "            float: left;\n" +
                "            width: 100%;\n" +
                "            height: 60%;\n" +
                "            object-fit: cover;\n" +
                "        }\n" +
                "\n" +
                "        li {\n" +
                "            float: left;\n" +
                "            list-style: none;\n" +
                "        }\n" +
                "\n" +
                "        li a {\n" +
                "            display: block;\n" +
                "            color: white;\n" +
                "            text-align: center;\n" +
                "            padding: 14px 16px;\n" +
                "            text-decoration: none;\n" +
                "            background-color: black;\n" +
                "        }\n" +
                "\n" +
                "        li a:hover {\n" +
                "            background-color: #04aa6d;\n" +
                "        }\n" +
                "\n" +
                "        ul {\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        .nav {\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "\n" +
                "        .name,\n" +
                "        .productLine,\n" +
                "        .productVendor {\n" +
                "            color: #000;\n" +
                "            margin-left: 8px;\n" +
                "        }\n" +
                "\n" +
                "        input[type=text] {\n" +
                "            float: right;\n" +
                "            padding: 6px;\n" +
                "            margin-top: 8px;\n" +
                "            margin-right: 16px;\n" +
                "            border: solid 1px #000;\n" +
                "            font-size: 17px;\n" +
                "        }\n" +
                "        button{\n" +
                "            width: 45%;\n" +
                "        }\n" +
                "        .footer{\n" +
                "            display: flex;\n" +
                "            justify-content: space-around;\n" +
                "        }");
        out.println("    </style>                                                                                                                                   ");
        out.println("</head>                                                                                                                                        ");
        out.println("<body>                                                                                                                                         ");
        out.println("    <div class=\"container\">                                                                                                                  ");
        out.println("        <div class=\"nav\">\n" +
                "            <ul>\n" +
                "                <li><a class=\"active\" href=\"#home\">Home</a></li>\n" +
                "                <li><a href=\"#news\">News</a></li>\n" +
                "                <li><a href=\"#contact\">Sales</a></li>\n" +
                "                <li><a href=\"#about\">Products</a></li>\n" +
                "                <li><a href=\"#news\">Your Cart</a></li>\n" +
                "                <li><a href=\"#contact\">Contact</a></li>\n" +
                "                <li><a href=\"#about\">About</a></li>\n" +
                "                <input type=\"text\" placeholder=\"Search..\">\n" +
                "            </ul>\n" +
                "        </div>");
        out.println("       <div class=\"product-container\">                                                                                                        ");
        for (Product value : productList) {
            out.println("<a href=\""+value.getProductLink()+"\" class=\"card\" id='product-component-" + value.getProductCode() + "'" + "></a>");
        }

        out.println("       </div>                                                                                                                                   ");
        out.println("     </div>                                                                                                                                     ");
        // Dùng jquerry up dữ liệu vào bảng
        out.println("<script>");
        out.println("const render = ()=>{");
        out.println("var txt1,txt2,txt3,txt4,txt5,txt6,txt7,var1;");
        productList.forEach(product -> {
            out.println("txt1 = '<div class=\"name\">Product: "+product.getProductName().replace("'","\\'")+"</div>'");
            out.println("txt2 = '<img class=\"img\" src=\""+product.getProductLink()+"\">'");
            out.println("txt3 = '<button class=\"btn btn-outline-warning price\">$"+product.getBuyPrice()+"</button>'");
            out.println("txt4 = '<div class=\"productLine\">Product Line: "+product.getProductLine()+"</div>'");
            out.println("txt5 = '<div class=\"productVendor\">Vendor: "+product.getProductVendor()+"</div>'");
            out.println("txt6 = '<div class=\"quantity\">"+product.getQuantityInStock()+"</div>'");
            out.println("txt7 = '<button class=\"btn btn-outline-warning buy\">Add to cart</button>'");
            out.println("txt8 = '<div class=\"footer item-footer"+product.getProductCode()+"\"></div>'");
            out.println("$(\"#product-component-"+product.getProductCode()+"\""+").append(txt2, txt1, txt5,txt4,txt8);");
            out.println("$(\".item-footer"+product.getProductCode()+"\").append(txt3,txt7);");

        });
        out.println("}");
        out.println("$(window).on('load',render());");
        out.println("</script>");



        out.println("</body>                                                                                                                                        ");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response){

    }
}
