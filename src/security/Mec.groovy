import groovy.xml.*;

def file = new File("/home/pabluxfirpux/Playground/out.xml");
def text = file.getText();
def parser = new XmlParser()
def project = parser.parseText(text);

//assert xml instanceof groovy.util.Node
def parentNode = project.children().find{ it.name() == 'properties' }
def permissionNode = parentNode.children().find{it.name() == 'hudson.security.AuthorizationMatrixProperty'}
def newElement = new groovy.util.Node(permissionNode, 'permission')
newElement.value = "USER:hudson.model.Item.Build:jenkinsuser"
def newElement2 = new groovy.util.Node(permissionNode, 'permission')
newElement2.value = "USER:hudson.model.Read.Build:jenkinsuser"
project.properties.add(newElement)
project.properties.add(newElement2)
println groovy.xml.XmlUtil.serialize(project)

