package org.example.service.impl;

import io.grpc.stub.StreamObserver;
import org.example.proto.GreeterGrpc;
import org.example.proto.GreeterProto;

public class GreeterServiceImpl extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(GreeterProto.HelloRequest request, StreamObserver<GreeterProto.HelloReply> responseObserver) {
        GreeterProto.HelloReply reply = GreeterProto.HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

}
