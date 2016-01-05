/*
 * Copyright (C) 2015 Benjamin Bader
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bendb.thrifty.integration;

import com.bendb.thrifty.integration.gen.Numberz;
import com.bendb.thrifty.integration.gen.ThriftTestClient;
import com.bendb.thrifty.integration.gen.Xtruct;
import com.bendb.thrifty.integration.gen.Xtruct2;
import com.bendb.thrifty.protocol.BinaryProtocol;
import com.bendb.thrifty.service.ClientBase;
import com.bendb.thrifty.testing.TestServer;
import com.bendb.thrifty.transport.SocketTransport;

import okio.ByteString;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * A test of auto-generated service code for the standard ThriftTest
 * service.
 *
 * <p>Conformance is checked by roundtripping requests to a local server that
 * is run on the official Apache Thrift Java codebase.  The test server has
 * an implementation of ThriftTest methods with semantics as described in the
 * .thrift file itself and in the Apache Thrift git repo, along with Java code
 * generated by their compiler.
 *
 * <p>Meanwhile, the client used here is entirely generated by Thrifty.  We
 * currently test the BinaryProtocol with an unadorned (i.e. non-framed)
 * transport.
 */
public class Conformance {
    @Rule public TestServer testServer = new TestServer();

    private SocketTransport transport;
    private BinaryProtocol protocol;
    private ThriftTestClient client;

    @Before
    public void setup() throws Exception {
        int port = testServer.port();
        transport = new SocketTransport.Builder("localhost", port)
                .readTimeout(2000)
                .build();

        transport.connect();
        protocol = new BinaryProtocol(transport);
        client = createClient();
    }

    @After
    public void teardown() throws Exception {
        if (protocol != null) {
            protocol.close();
            protocol = null;
        }

        if (transport != null) {
            transport.close();
            transport = null;
        }
    }

    @Test
    public void testVoid() throws Throwable {
        AssertingCallback<Void> callback = new AssertingCallback<>();
        client.testVoid(callback);

        assertThat(callback.getResult(), is(nullValue()));
    }

    @Test
    public void testBool() throws Throwable {
        AssertingCallback<Boolean> callback = new AssertingCallback<>();
        client.testBool(Boolean.TRUE, callback);

        assertThat(callback.getResult(), is(Boolean.TRUE));
    }

    @Test
    public void testByte() throws Throwable {
        AssertingCallback<Byte> callback = new AssertingCallback<>();
        client.testByte((byte) 200, callback);

        assertThat(callback.getResult(), is((byte) 200));
    }

    @Test
    public void testI32() throws Throwable {
        AssertingCallback<Integer> callback = new AssertingCallback<>();
        client.testI32(404, callback);

        assertThat(callback.getResult(), is(404));
    }

    @Test
    public void testI64() throws Throwable {
        AssertingCallback<Long> callback = new AssertingCallback<>();
        client.testI64(Long.MAX_VALUE, callback);

        assertThat(callback.getResult(), is(Long.MAX_VALUE));
    }

    @Test
    public void testDouble() throws Throwable {
        AssertingCallback<Double> callback = new AssertingCallback<>();
        client.testDouble(Math.PI, callback);

        assertThat(callback.getResult(), is(Math.PI));
    }

    @Test
    public void testBinary() throws Throwable {
        ByteString binary = ByteString.encodeUtf8("Peace on Earth and Thrift for all mankind");

        AssertingCallback<ByteString> callback = new AssertingCallback<>();
        client.testBinary(binary, callback);

        assertThat(callback.getResult(), equalTo(binary));
    }

    @Test
    public void testEnum() throws Throwable {
        Numberz argument = Numberz.EIGHT;

        AssertingCallback<Numberz> callback = new AssertingCallback<>();
        client.testEnum(argument, callback);

        assertThat(callback.getResult(), equalTo(Numberz.EIGHT));
    }

    @Test
    public void testStruct() throws Throwable {
        Xtruct xtruct = new Xtruct.Builder()
                .byte_thing((byte) 1)
                .i32_thing(2)
                .i64_thing(3L)
                .string_thing("foo")
                .build();

        AssertingCallback<Xtruct> callback = new AssertingCallback<>();
        client.testStruct(xtruct, callback);

        assertThat(callback.getResult(), equalTo(xtruct));
    }

    @Test
    public void testNest() throws Throwable {
        Xtruct xtruct = new Xtruct.Builder()
                .byte_thing((byte) 1)
                .i32_thing(2)
                .i64_thing(3L)
                .string_thing("foo")
                .build();

        Xtruct2 nest = new Xtruct2.Builder()
                .byte_thing((byte) 4)
                .i32_thing(5)
                .struct_thing(xtruct)
                .build();

        AssertingCallback<Xtruct2> callback = new AssertingCallback<>();

        client.testNest(nest, callback);

        assertThat(callback.getResult(), equalTo(nest));
    }

    @Test
    public void testMap() throws Throwable {
        Map<Integer, Integer> argument = new HashMap<>();
        argument.put(1, 2);
        argument.put(3, 4);
        argument.put(7, 8);

        AssertingCallback<Map<Integer, Integer>> callback = new AssertingCallback<>();
        client.testMap(argument, callback);

        assertThat(callback.getResult(), equalTo(argument));
    }

    @Test
    public void testStringMap() throws Throwable {
        Map<String, String> argument = new HashMap<>();
        argument.put("foo", "bar");
        argument.put("baz", "quux");
        argument.put("one", "more");

        AssertingCallback<Map<String, String>> callback = new AssertingCallback<>();
        client.testStringMap(argument, callback);

        assertThat(callback.getResult(), equalTo(argument));
    }

    private ThriftTestClient createClient() {
        return new ThriftTestClient(protocol, new ClientBase.Listener() {
            @Override
            public void onTransportClosed() {

            }

            @Override
            public void onError(Throwable error) {

            }
        });
    }
}