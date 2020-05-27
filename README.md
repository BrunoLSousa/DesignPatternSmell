# Design Pattern Smell

*A Tool for Detection of Co-Occurrences between Design Patterns and Bad Smells*

Tool for detection of co-occurrences between design pattern and bad smell in JAVA software system. A co-occurrence occurs when a 
class or method that is part of a design pattern instance has the presence of bad smell.

## Goal

Design Pattern Smell is a tool developed in the programing language JAVA that support the detection of co-occurrences between design 
pattern and bad smells in software system. The tool receives as input XML files containing the design patterns instances and a CSV 
file containing classes or methods with bad smell. Design Pattern Smell performs the parser of this information and then a data 
crossing to detect the co-occurrences. In addition, Design Pattern Smell allows the user to apply association rules on the data 
collected to identify the intensity of the co-occurrence in each design pattern, and to export reports for analysis and future 
manipulations. Design Pattern Smell supports co-occurrence detection in 14 GOF catalog design patterns:
  - **Adapter**
  - **Bridge**
  - **Command**
  - **Composite**
  - **Decorator**
  - **Factory Method**
  - **Observer**
  - **Prototype**
  - **Proxy**
  - **State**
  - **Singleton**
  - **Strategy**
  - **Template Method**
  - **Visitor**

## Main Features

### Versão 1.0
- **Import of Computed Design Pattern Instances;**
- **Import of Computed Artifacts with Bad Smells;**
- **Application of Association Rules;**
- **Result Generation, Visualization and Export;**
- **Data Management;**
- **Help;**

### Versão 1.1
- **Parser support for instances of the Adapter and Command design patterns separately;**
- **Parser support for instances of the State and Strategy design patterns separately;**
- **Parser support for instances of the Chain of Responsibility design pattern;**

## Links

An example video usage has been made available on YouTube. It can be found at the following link:
- **https://youtu.be/hFwyId9nHnM**

For more information, visit the Design Pattern Smell tool page. There, you can find the documentation and the its jar executable file. 
The page can be found at the following link:
- **http://llp.dcc.ufmg.br/Products/indexProducts.html**

## Design Pattern Smell Installation Requirements

For use of Design Pattern Smell, it is necessary to have jre, version 7 or higher, JAVA installed on the target machine.

## Installation and Execution Guide

For to make the installation of Design Pattern Smell, follow the following steps:

* Make the download of jar executable file in the Design Pattern Smell tool page;

* Run the file jar with your JAVA.

* Ready. You can now use Design Pattern Smell to detect co-occurrences between design pattern and bad smells in software.

## Development Information

Design Pattern Smell was developed in 2017 by:
  - <a href="https://homepages.dcc.ufmg.br/~bruno.luan.sousa/">Bruno L. Sousa (UFMG)</a> <a href="mailto:bruno.luan.sousa@gmail.com"> <img src="http://partitoccitan.org/wp-content/uploads/2015/02/699049-icon-6-mail-envelope-closed-128.png" width="30px" height="30px" alt="Contact" /> </a>
  - <a href="https://homepages.dcc.ufmg.br/~mariza/">Mariza A. S. Bigonha (UFMG)</a> <a href="mailto:mariza@dcc.ufmg.br"> <img src="http://partitoccitan.org/wp-content/uploads/2015/02/699049-icon-6-mail-envelope-closed-128.png" width="30px" height="30px" alt="Contact" /> </a>
  - <a href="https://homepages.dcc.ufmg.br/~kecia/">Kecia A. M. Ferreira (CEFET-MG)</a> <a href="mailto:kecia@decom.cefetmg.br"> <img src="http://partitoccitan.org/wp-content/uploads/2015/02/699049-icon-6-mail-envelope-closed-128.png" width="30px" height="30px" alt="Contact" /> </a>
