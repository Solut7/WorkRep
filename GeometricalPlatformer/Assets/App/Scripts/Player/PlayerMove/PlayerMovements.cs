using System;
using UnityEngine;

namespace App.Scripts.Player.PlayerMove

{
    public class PlayerMovements : MonoBehaviour
    {
        private Rigidbody2D _body;
       [SerializeField] float _speed;
       private Animator _anim;
       private bool _grounded;
       private void Awake()
        {
            //Take references for components
            _body = GetComponent<Rigidbody2D>();
            _anim = GetComponent<Animator>();
        }

        private void Update()
        {
            float _horizontalInput = Input.GetAxis("Horizontal");
            _body.velocity = new Vector2(_horizontalInput*_speed,_body.velocity.y);
            
            //Flip player
            if(_horizontalInput>0.01f)
                transform.localScale = Vector3.one;
            else if (_horizontalInput < -0.01f)
                transform.localScale = new Vector3(-1,1,1);
            
            if(Input.GetKey(KeyCode.Space) && _grounded)
               Jump();
            
            _anim.SetBool("run", _horizontalInput!=0);
            _anim.SetBool("grounded", _grounded);
        }

        private void Jump()
        {
            _body.velocity = new Vector2(_body.velocity.x,_speed);
            _grounded = false;
        }

        private void OnCollisionEnter2D(Collision2D other)
        {
            if (other.gameObject.tag == "Ground")
                _grounded = true;
        }
    }
}

