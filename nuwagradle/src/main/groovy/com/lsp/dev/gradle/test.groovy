package com.lsp.dev

println "helloworld"
def aList = [5, "s", true]
aList[100] = 100
assert aList[100] == 100
println aList.size

def aMap = ['key1': 'value1', 'key2': 'true']
println aMap['key1']

def aClosure = {
    String param1, int param2 ->
        println "im a closure with params"
}

def aClosure1 =
        {
            println "I am a closure no params "
        }

aClosure.call("1111", 111)

def greeting = {
    it -> "hello,$it"
}
def greeting1 = {
    "hello,$it"
}
//默认会有参数$it  greeting1  和  greeting 等效
assert greeting('Patrick') == 'hello,Patrick'

//下面这种写法是无参数的，不能传参数 否则会报错
def greeting2 = {
    -> "hello"
}

//greeting2("a")

//函数传递闭包作为参数
def iamList = [1, 2, 3, 4, 5]

iamList.each {
    println it
}


def testClosure(int a, String b, Closure closure) {
    closure();
}

testClosure(4, "test", {
    println "i am a test for closure"
})

//成员函数
import groovy.transform.Field
import groovy.util.slurpersupport.GPathResult;

//def x=1
@Field x = 1
def testField = {
    -> println x
}

def testField1() {
    println x
}

testField.call()
testField1()

//文件io操作
def targetFile = new File("a.txt")
targetFile.append("12345678")
targetFile.append("我是下一行")

targetFile.eachLine {
    String oneLine ->
        println oneLine
}

targetFile.withInputStream {
    ism ->
        println '这是一个对输入流的测试:'
        println ism.getText("UTF8")
}

//这是一个复制文件的测试

def inFile = new File("a.txt")
def outFile = new File("oFile.txt")
outFile.withOutputStream {
    os ->
        inFile.withInputStream {
            ins ->
                os << ins
                println "这是一个复制文件的测试:"
                println outFile.getText("UTF8")
        }
}

//这是一个关于xml解析的测试

def xparser = new XmlSlurper()
def tartFile = new File("AndroidManifest.xml");
//gpath获取解析xml的结果
GPathResult gPathResult = xparser.parse(tartFile)
//获取结果的属性
def versionName = gPathResult['@android:versionName']

println 'application的属性:' + gPathResult.application['@android:supportsRtl']//子节点的属性

println 'versionName is:' + versionName



