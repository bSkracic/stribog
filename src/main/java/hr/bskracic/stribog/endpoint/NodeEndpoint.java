package hr.bskracic.stribog.endpoint;

import hr.bskracic.stribog.repository.NodeRepository;
import io.spring.guides.gs_producing_web_service.GetNodesRequest;
import io.spring.guides.gs_producing_web_service.GetNodesResponse;
import io.spring.guides.gs_producing_web_service.NodeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.Collection;

@Endpoint
@RequiredArgsConstructor
public class NodeEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final NodeRepository nodeRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getNodesRequest")
    @ResponsePayload
    public GetNodesResponse getNodes(@RequestPayload GetNodesRequest request) {
        GetNodesResponse response = new GetNodesResponse();
        Collection<NodeDto> nodes = new ArrayList<>();
        nodeRepository.findAll().forEach(n -> {
            NodeDto nodeDto = new NodeDto();
            nodeDto.setName(n.getName());
            nodeDto.setImage(n.getImage());
            nodeDto.setId(n.getId());
            nodes.add(nodeDto);
        });
        response.getNodeList().addAll(nodes);

        return response;
    }
}
