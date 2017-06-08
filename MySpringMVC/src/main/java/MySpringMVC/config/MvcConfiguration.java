package MySpringMVC.config;

import javax.sql.DataSource;

import MySpringMVC.dao.*;
import MySpringMVC.model.Damage;
import MySpringMVC.model.Earthquake;
import MySpringMVC.model.Municipality;
import MySpringMVC.model.Village;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "MySpringMVC")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
        dataSource.setUsername("ION");
        dataSource.setPassword("ION");

        return dataSource;
    }

    @Bean
    public DistrictDAO getDistrictDAO() {
        return new DistrictDAOImpl(getDataSource());
    }

    @Bean
    public MunicipalityDAO getMunicipalityDAO() {
        return new MunicipalityDAOImpl(getDataSource());
    }

    @Bean
    public VillageDAO getVillageDAO() {
        return new VillageDAOImpl(getDataSource());
    }

    @Bean
    public EarthquakeDAO getEartquakeDAO() {
        return new EarthquakeDAOImpl(getDataSource());
    }

    @Bean
    public DamageDAO getDamageDAO() {
        return new DamageDAOImpl(getDataSource());
    }

    @Bean
    public ClusterDAO getClusterDAO() {
        return new ClusterDAOImpl(getDataSource());
    }

    @Bean
    public TablesDAOImpl getTablesDAO() {
        return new TablesDAOImpl(getDataSource());
    }

    @Bean
    public ChartViewDAOImpl getChartViewDAO() {
        return new ChartViewDAOImpl(getDataSource());
    }

    @Bean
    public GraphViewDAOImpl getGraphViewDAO() {
        return new GraphViewDAOImpl(getDataSource());
    }

    @Bean
    public MapViewDAOImpl getMapViewDAO() {
        return new MapViewDAOImpl(getDataSource());
    }

    @Bean
    public SimpleTableViewDAOImpl getSimpleTableViewDAO() {
        return new SimpleTableViewDAOImpl(getDataSource());
    }

}
