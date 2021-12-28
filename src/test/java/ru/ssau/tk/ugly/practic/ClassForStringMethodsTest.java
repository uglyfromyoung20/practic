package ru.ssau.tk.ugly.practic;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ClassForStringMethodsTest {

    @Test
    public void testIsTheStringAPalindrome() {
        ClassForStringMethods object = new ClassForStringMethods();
        String firstString = "asdffdsa", secondString = "qwertyyyewq", thirdString = "gurtrug", fourthString = "rwketafwr";
        Assert.assertTrue(object.isTheStringAPalindrome(firstString));
        Assert.assertTrue(object.isTheStringAPalindrome(thirdString));
        Assert.assertFalse(object.isTheStringAPalindrome(secondString));
        Assert.assertFalse(object.isTheStringAPalindrome(fourthString));
    }

    @Test
    public void testDoTheStringsDifferOnlyInCase() {
        ClassForStringMethods object = new ClassForStringMethods();
        Assert.assertTrue(object.doTheStringsDifferOnlyInCase("EpSILoNN", "EpsilonN"));
        Assert.assertTrue(object.doTheStringsDifferOnlyInCase("AlIyFa", "alIYFA"));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase(null, null));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase(null, "FALSe"));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase("FAlse", null));
        Assert.assertFalse(object.doTheStringsDifferOnlyInCase("CoNtROLL", "ShiFT"));
    }

    @Test
    public void testSubstringSearch() {
        ClassForStringMethods object = new ClassForStringMethods();
        Assert.assertEquals(object.substringSearch("coalition", "al"), 2);
        Assert.assertEquals(object.substringSearch("cocylka", "lka"), 4);
        Assert.assertEquals(object.substringSearch("kilometre", "awq"), -1);
    }

    @Test
    public void testSubstringSearchInTheSecondHalf() {
        ClassForStringMethods object = new ClassForStringMethods();
        Assert.assertEquals(object.substringSearchInTheSecondHalf("deinstitutionalization", "at"), 17);
        Assert.assertEquals(object.substringSearchInTheSecondHalf("deinstitutionalization", "io"), 19);
        Assert.assertEquals(object.substringSearchInTheSecondHalf("deinstitutionalization", "al"), 13);
        Assert.assertEquals(object.substringSearchInTheSecondHalf("deinstitutionalization", "xyz"), -1);
    }

    @Test
    public void testLastIndexOfSubstringInStringInFirstHalf() {
        ClassForStringMethods object = new ClassForStringMethods();
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "oc"), 2);
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "nauc"), 6);
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "ihi"), 12);
        Assert.assertEquals(object.lastIndexOfSubstringInStringInFirstHalf("Floccinaucinihilipilification", "zxy"), -1);
    }

    @Test
    public void testGetNumberOfLinesWithSpecifiedStartAndEnd() {
        ClassForStringMethods object = new ClassForStringMethods();
        String[] array = {"asxdoktr", "asxutyopi", "gyrteopi"};
        Assert.assertEquals(object.getNumberOfLinesWithSpecifiedStartAndEnd(array, "asx", "opi"), 1);
        array = new String[]{"oufrtsqp", "ghutyinsqp", "ghujfoisesqp"};
        Assert.assertEquals(object.getNumberOfLinesWithSpecifiedStartAndEnd(array, "ghu", "sqp"), 2);
    }

    @Test
    public void testGetNumberOfLinesWithSpecifiedStartAndEndWithoutSpaces() {
        ClassForStringMethods object = new ClassForStringMethods();
        String[] array = {" obvporfdsw ", "  ovbnfrd  ", "     ovboutydsw   "};
        Assert.assertEquals(object.getNumberOfLinesWithSpecifiedStartAndEndWithoutSpaces(array, "ovb", "dsw"), 1);
        array = new String[]{"  kuhlsnlob ", " kuhmksldvn  ", "   kuhfiudlob   "};
        Assert.assertEquals(object.getNumberOfLinesWithSpecifiedStartAndEndWithoutSpaces(array, "kuh", "lob"), 2);
    }

    @Test
    public void testReplaceAllSubstringsInString() {
        ClassForStringMethods object = new ClassForStringMethods();
        String string = "dogodogoddo";
        Assert.assertEquals(object.replaceAllSubstringsInString(string, "do", "us"), "usgousgodus");
        string = "oboodoboboobbobobobooobob";
        Assert.assertEquals(object.replaceAllSubstringsInString(string, "obo", "ob"), "obdobboobbobbobbb");
    }

    @Test
    public void testSearchASubstringWithConditions() {
        ClassForStringMethods object = new ClassForStringMethods();
        String string = "Antidisestablishmentarianism";
        Assert.assertNull(object.searchASubstringWithConditions(string, 8, 6));
        Assert.assertEquals(object.searchASubstringWithConditions(string, -2, 10), "Antidisest");
        Assert.assertEquals(object.searchASubstringWithConditions(string, 24, 30), "nism");
        Assert.assertEquals(object.searchASubstringWithConditions(string, 10, 20), "ablishment");
    }

    @Test
    public void testSplittingAStringIntoSeparateWords() {
        ClassForStringMethods object = new ClassForStringMethods();
        String sourceString = "sign ghost participle adjective uncomplicated";
        Assert.assertEquals(object.splittingAStringIntoSeparateWords(sourceString), new String[]{"Sign", "Ghost",//
                "Participle", "Adjective", "Uncomplicated"});
        sourceString = "bear lynx  bird thor calendar";
        Assert.assertEquals(object.splittingAStringIntoSeparateWords(sourceString), new String[]{"Bear", "Lynx", "",//
                "Bird", "Thor", "Calendar"});
    }

    @Test
    public void testCombiningAllRowsIntoOne() {
        ClassForStringMethods object = new ClassForStringMethods();
        String[] stringArray = {"dream", "cubicle", "man"};
        Assert.assertEquals(object.combiningAllRowsIntoOne(stringArray), "dream, cubicle, man");
    }

    @Test
    public void testChangingLettersToIndexes() {
        ClassForStringMethods object = new ClassForStringMethods();
        String string = "electricity";
        Assert.assertEquals(object.changingLettersToIndexes(string), "y01i8i6t4e2e");
        string = "spotted";
        Assert.assertEquals(object.changingLettersToIndexes(string), "d6t4o2s");
    }

    @Test
    public void testNumberEnumerationString() {
        ClassForStringMethods object = new ClassForStringMethods();
        Assert.assertEquals(object.numberEnumerationString(7), "0 1 2 3 4 5 6 ");
        Assert.assertEquals(object.numberEnumerationString(15), "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 ");
    }
}