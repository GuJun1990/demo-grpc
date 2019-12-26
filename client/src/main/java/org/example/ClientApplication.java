package org.example;

import com.googlecode.protobuf.format.JsonFormat;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.proto.GreeterGrpc;
import org.example.proto.GreeterProto;

/**
 * Hello world!
 *
 */
public class ClientApplication {

    public static void main( String[] args ) {
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:50051")
                .usePlaintext()
                .build();
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        GreeterProto.HelloRequest request = GreeterProto.HelloRequest
                .newBuilder()
                .setName("GuJun")
                .build();
        GreeterProto.HelloReply reply = stub.sayHello(request);
        System.out.println(JsonFormat.printToString(reply));
        channel.shutdown();
    }

}
