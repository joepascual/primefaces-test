package org.primefaces.test;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import lombok.Data;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {
    
    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;
    private List<TestObject> list;
    
    private TreeNode<TestObject> root;
    
    @PostConstruct  
    public void init() {
        string = "Welcome to PrimeFaces!!!";
        list = new ArrayList<>(Arrays.asList(
                new TestObject("Thriller", "Michael Jackson", 1982),
                new TestObject("Back in Black", "AC/DC", 1980),
                new TestObject("The Bodyguard", "Whitney Houston", 1992),
                new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973)
        ));
        
        root = new DefaultTreeNode<>(new TestObject("", "", 0), null);
        list.stream().forEach(to -> new DefaultTreeNode<>(to, root));
        
        
    }

}
