package ge.bog.intern.bonus_and_rating_system.controller.listener;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import ge.bog.intern.bonus_and_rating_system.manager.DAO;
import ge.bog.intern.bonus_and_rating_system.manager.db.DBInfo;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {

            MysqlDataSource dataSource = new MysqlDataSource();

            dataSource.setUser("root");
            dataSource.setPassword("saba");
            dataSource.setURL("jdbc:mysql://localhost:3306/bonus_and_rating_system");

            // Creating DAO layers

            DAO dao = new DAO(dataSource);

            // Saving DAO layers to context for further use

            sce.getServletContext().setAttribute("DAO", dao);

    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
