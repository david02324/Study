using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class GameManager : MonoBehaviour
{

    public GameObject winUI;
    public ItemBox[] boxes;

    public bool isGameOver;
    // Start is called before the first frame update
    void Start()
    {
        isGameOver = false;
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetKeyDown(KeyCode.Space))
        {
            SceneManager.LoadScene("main");
        }

        int count = 0;
        if (isGameOver)
        {
            return;
        }

        for (int i = 0; i < 3; i++)
        {
            if (boxes[i].isOveraped == true)
            {
                count++;
            }
        }

        if (count >= 3)
        {
            isGameOver = true;
            winUI.SetActive(true);
        }
    }
}
