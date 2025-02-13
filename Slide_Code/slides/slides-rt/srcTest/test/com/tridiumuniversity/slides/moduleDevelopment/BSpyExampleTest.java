/*
 * Copyright 2024 Tridium, Inc. All Rights Reserved. This code is supplied as example code only and is not intended for use in production.
 */

package test.com.tridiumuniversity.slides.moduleDevelopment;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import javax.baja.naming.BOrd;
import javax.baja.nre.annotations.NiagaraType;
import javax.baja.spy.BSpy;
import javax.baja.spy.SpyWriter;
import javax.baja.sys.BBoolean;
import javax.baja.sys.Sys;
import javax.baja.sys.Type;
import javax.baja.test.BTestNg;

import com.tridiumuniversity.slides.moduleDevelopment.BSpyExample;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@NiagaraType
@Test
public class BSpyExampleTest extends BTestNg
{
//region /*+ ------------ BEGIN BAJA AUTO GENERATED CODE ------------ +*/
//@formatter:off
/*@ $test.com.tridiumuniversity.slides.moduleDevelopment.BSpyExampleTest(2979906276)1.0$ @*/
/* Generated Fri Oct 06 16:30:18 EDT 2023 by Slot-o-Matic (c) Tridium, Inc. 2012-2023 */

  //region Type

  @Override
  public Type getType() { return TYPE; }
  public static final Type TYPE = Sys.loadType(BSpyExampleTest.class);

  //endregion Type

//@formatter:on
//endregion /*+ ------------ END BAJA AUTO GENERATED CODE -------------- +*/

  public void spyPageContainsOptions()
    throws Exception
  {
    BSpyExample spyExample = new BSpyExample();
    spyExample.setOptionName("spyExampleTestOption1");
    spyExample.doAddOption(BBoolean.TRUE, null);
    spyExample.setOptionName("spyExampleTestOption2");
    spyExample.doAddOption(BBoolean.FALSE, null);

    BSpy spy = (BSpy)BOrd.make("spy:/slidesTest").get();
    StringWriter stringWriter = new StringWriter();
    SpyWriter spyWriter = new SpyWriter(stringWriter, spy.getPath());

    spyExample.spy(spyWriter);
    String documentString = String.format("<html>%s</html>", stringWriter);
    Document document = parseDocument(documentString);

    // The following strings are queries against the spy page HTML. They use XPath syntax. The first query can be broken
    // down as follows:
    //   //                                 - match the following regardless of its location in the document
    //   td                                 - look for a <td> HTML node
    //   [@class = 'spy-prop-name']         - with a class of spy-prop-name
    //   [text() = 'spyExampleTestOption1'] - and text equal to spyExampleTestOption1
    String option1KeyQuery = "//td[@class = 'spy-prop-name'][text() = 'spyExampleTestOption1']";
    String option1ValueQuery = "//td[@class = 'spy-prop-value'][text() = 'true']";
    String option2KeyQuery = "//td[@class = 'spy-prop-name'][text() = 'spyExampleTestOption2']";
    String option2ValueQuery = "//td[@class = 'spy-prop-value'][text() = 'false']";

    Assert.assertTrue(containsQuery(document, option1KeyQuery), "Spy page should contain added options");
    Assert.assertTrue(containsQuery(document, option1ValueQuery), "Spy page should contain added options");
    Assert.assertTrue(containsQuery(document, option2KeyQuery), "Spy page should contain added options");
    Assert.assertTrue(containsQuery(document, option2ValueQuery), "Spy page should contain added options");
  }

  // The below methods handle creating a W3C Document and querying its contents using XPath
  private Document parseDocument(String documentString)
    throws ParserConfigurationException, IOException, SAXException
  {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
    return documentBuilder.parse(new InputSource(new StringReader(documentString)));
  }

  private boolean containsQuery(Document document, String query)
  {
    XPath xPath = XPathFactory.newInstance().newXPath();

    try
    {
      NodeList nodeList = (NodeList)xPath.compile(query).evaluate(document, XPathConstants.NODESET);
      return nodeList.getLength() > 0;
    }
    catch(XPathExpressionException ex)
    {
      return false;
    }
  }
}
