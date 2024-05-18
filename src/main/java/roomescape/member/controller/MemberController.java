package roomescape.member.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomescape.member.controller.dto.request.SignupRequest;
import roomescape.member.controller.dto.response.MemberResponse;
import roomescape.member.controller.dto.response.SignupResponse;
import roomescape.member.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public ResponseEntity<SignupResponse> save(@RequestBody @Valid final SignupRequest signupRequest) {
        SignupResponse signupResponse = SignupResponse.from(memberService.save(signupRequest));
        return ResponseEntity.ok(signupResponse);
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getAll() {
        List<MemberResponse> memberResponses = MemberResponse.list(memberService.getAll());
        return ResponseEntity.ok(memberResponses);
    }
}
