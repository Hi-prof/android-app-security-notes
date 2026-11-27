package io.dcloud.common.util;

/* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
/* JADX INFO: loaded from: classes2.dex */
public class XmlUtil {
    public static final int CDATA = 4;
    public static final int ELEMENT = 1;
    public static final int TEXT = 3;

    /* JADX INFO: compiled from: r8-map-id-8c1055c49cc75bcabf9ef34f19cef880f5b46b9f12a640b71ae12a9dba5edeed */
    public static class DHNode {
        org.w3c.dom.Node mNode;

        public boolean equals(java.lang.Object obj) {
            return obj instanceof io.dcloud.common.util.XmlUtil.DHNode ? this.mNode.equals(((io.dcloud.common.util.XmlUtil.DHNode) obj).mNode) : super.equals(obj);
        }

        private DHNode(org.w3c.dom.Node node) {
            this.mNode = node;
        }
    }

    public static io.dcloud.common.util.XmlUtil.DHNode XML_Parser(java.io.InputStream inputStream) {
        try {
            return new io.dcloud.common.util.XmlUtil.DHNode(((org.w3c.dom.Document) XML_ParserDocument(inputStream).mNode).getDocumentElement());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static io.dcloud.common.util.XmlUtil.DHNode XML_ParserDocument(java.io.InputStream inputStream) {
        try {
            javax.xml.parsers.DocumentBuilderFactory documentBuilderFactoryNewInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
            documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
            return new io.dcloud.common.util.XmlUtil.DHNode(documentBuilderFactoryNewInstance.newDocumentBuilder().parse(inputStream));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void addChild(io.dcloud.common.util.XmlUtil.DHNode dHNode, io.dcloud.common.util.XmlUtil.DHNode dHNode2, int i) {
        dHNode.mNode.appendChild(dHNode2.mNode);
    }

    public static void attrFill2HashMap(java.util.HashMap<java.lang.String, java.lang.String> map, io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        org.w3c.dom.NamedNodeMap attributes;
        if (dHNode == null || map == null) {
            return;
        }
        org.w3c.dom.Node node = dHNode.mNode;
        if (!(node instanceof org.w3c.dom.Element) || (attributes = ((org.w3c.dom.Element) node).getAttributes()) == null || attributes.getLength() <= 0) {
            return;
        }
        for (int i = 0; i < attributes.getLength(); i++) {
            org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attributes.item(i);
            map.put(attr.getName(), attr.getValue());
        }
    }

    public static java.lang.String elementToString(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        return new java.io.StringWriter().toString();
    }

    public static java.lang.String getAttributeValue(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str, java.lang.String str2) {
        java.lang.String attributeValue = getAttributeValue(dHNode, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static java.util.ArrayList<java.lang.String[]> getAttributes(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        org.w3c.dom.NamedNodeMap attributes;
        java.util.ArrayList<java.lang.String[]> arrayList = null;
        if (dHNode == null) {
            return null;
        }
        org.w3c.dom.Node node = dHNode.mNode;
        if ((node instanceof org.w3c.dom.Element) && (attributes = ((org.w3c.dom.Element) node).getAttributes()) != null && attributes.getLength() > 0) {
            arrayList = new java.util.ArrayList<>();
            for (int i = 0; i < attributes.getLength(); i++) {
                org.w3c.dom.Attr attr = (org.w3c.dom.Attr) attributes.item(i);
                arrayList.add(new java.lang.String[]{attr.getName(), attr.getValue(), attr.getNamespaceURI()});
            }
        }
        return arrayList;
    }

    public static io.dcloud.common.util.XmlUtil.DHNode getChild(io.dcloud.common.util.XmlUtil.DHNode dHNode, int i) {
        org.w3c.dom.NodeList childNodes;
        if (dHNode == null || (childNodes = dHNode.mNode.getChildNodes()) == null) {
            return null;
        }
        return new io.dcloud.common.util.XmlUtil.DHNode(childNodes.item(i));
    }

    public static io.dcloud.common.util.XmlUtil.DHNode getElement(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str) {
        org.w3c.dom.Node nodeItem;
        if (dHNode == null) {
            return null;
        }
        org.w3c.dom.Node node = dHNode.mNode;
        if (!(node instanceof org.w3c.dom.Element) || (nodeItem = ((org.w3c.dom.Element) node).getElementsByTagName(str).item(0)) == null) {
            return null;
        }
        return new io.dcloud.common.util.XmlUtil.DHNode(nodeItem);
    }

    public static io.dcloud.common.util.XmlUtil.DHNode getElementDocument(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        return new io.dcloud.common.util.XmlUtil.DHNode(dHNode.mNode.getOwnerDocument());
    }

    public static java.lang.String getElementName(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        return dHNode.mNode.getNodeName();
    }

    public static java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> getElements(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str) {
        org.w3c.dom.NodeList elementsByTagName;
        if (dHNode == null) {
            return null;
        }
        org.w3c.dom.Node node = dHNode.mNode;
        if (!(node instanceof org.w3c.dom.Element) || (elementsByTagName = ((org.w3c.dom.Element) node).getElementsByTagName(str)) == null) {
            return null;
        }
        java.util.ArrayList<io.dcloud.common.util.XmlUtil.DHNode> arrayList = new java.util.ArrayList<>(2);
        int length = elementsByTagName.getLength();
        for (int i = 0; i < length; i++) {
            arrayList.add(new io.dcloud.common.util.XmlUtil.DHNode(elementsByTagName.item(i)));
        }
        return arrayList;
    }

    public static int getNodeType(io.dcloud.common.util.XmlUtil.DHNode dHNode, int i) {
        if (dHNode == null) {
            return -1;
        }
        return dHNode.mNode.getNodeType();
    }

    public static io.dcloud.common.util.XmlUtil.DHNode getRootElement(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        try {
            org.w3c.dom.Node node = dHNode.mNode;
            if (node instanceof org.w3c.dom.Document) {
                return new io.dcloud.common.util.XmlUtil.DHNode(((org.w3c.dom.Document) node).getDocumentElement());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static java.lang.String getText(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (dHNode == null) {
            return stringBuffer.toString();
        }
        org.w3c.dom.Node node = dHNode.mNode;
        if (node instanceof org.w3c.dom.Element) {
            org.w3c.dom.NodeList childNodes = ((org.w3c.dom.Element) node).getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                stringBuffer.append(childNodes.item(i).getNodeValue());
            }
        }
        return stringBuffer.toString();
    }

    public static java.lang.String getTextValue(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        return ((org.w3c.dom.Text) dHNode.mNode).getNodeValue();
    }

    public static boolean isElement(java.lang.Object obj) {
        return obj instanceof org.w3c.dom.Element;
    }

    public static boolean isText(io.dcloud.common.util.XmlUtil.DHNode dHNode) {
        return dHNode.mNode instanceof org.w3c.dom.Text;
    }

    public static io.dcloud.common.util.XmlUtil.DHNode newDocument() {
        javax.xml.parsers.DocumentBuilderFactory documentBuilderFactoryNewInstance = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        try {
            return new io.dcloud.common.util.XmlUtil.DHNode(documentBuilderFactoryNewInstance.newDocumentBuilder().newDocument());
        } catch (javax.xml.parsers.ParserConfigurationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static io.dcloud.common.util.XmlUtil.DHNode newElement(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str) {
        return new io.dcloud.common.util.XmlUtil.DHNode(dHNode.mNode.getOwnerDocument().createElement(str));
    }

    public static void removeAttribute(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str) {
        org.w3c.dom.Node node = dHNode.mNode;
        if (node == null) {
            return;
        }
        node.getAttributes().removeNamedItem(str);
    }

    public static void removeChild(io.dcloud.common.util.XmlUtil.DHNode dHNode, int i) {
        org.w3c.dom.Node node = dHNode.mNode;
        node.removeChild(node.getChildNodes().item(i));
    }

    public static void setAttributeValue(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str, java.lang.String str2) {
        org.w3c.dom.Node node = dHNode.mNode;
        if (node instanceof org.w3c.dom.Element) {
            ((org.w3c.dom.Element) node).setAttribute(str, str2);
        }
    }

    public static void setText(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str) {
        dHNode.mNode.setNodeValue(str);
    }

    public static int getAttributeValue(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str, int i) {
        try {
            return java.lang.Integer.parseInt(getAttributeValue(dHNode, str, java.lang.String.valueOf(i)));
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            return i;
        }
    }

    public static void removeChild(io.dcloud.common.util.XmlUtil.DHNode dHNode, io.dcloud.common.util.XmlUtil.DHNode dHNode2) {
        if (dHNode2 == null) {
            return;
        }
        dHNode.mNode.removeChild(dHNode2.mNode);
    }

    public static java.lang.String getAttributeValue(io.dcloud.common.util.XmlUtil.DHNode dHNode, java.lang.String str) {
        if (dHNode == null) {
            return null;
        }
        org.w3c.dom.Node node = dHNode.mNode;
        if (node instanceof org.w3c.dom.Element) {
            return ((org.w3c.dom.Element) node).getAttribute(str);
        }
        return null;
    }
}
